/*
 * The JastAdd Extensible Java Compiler (http://jastadd.org) is covered
 * by the modified BSD License. You should have received a copy of the
 * modified BSD license with this compiler.
 * 
 * Copyright (c) 2005-2008, Torbjorn Ekman
 * All rights reserved.
 */

import AST.*;
import java.io.*;
import java.util.*;

class JavaCompiler extends Frontend {
  public static void main(String args[]) {
    if(!compile(args))
      System.exit(1);
  }

  public static boolean compile(String args[]) {
    return new JavaCompiler().process(
        args,
        new BytecodeParser(),
        new JavaParser() {
          public CompilationUnit parse(java.io.InputStream is, String fileName) throws java.io.IOException, beaver.Parser.Exception {
            return new parser.JavaParser().parse(is, fileName);
          }
        }
    );
  }

  public boolean process(String[] args, BytecodeReader reader, JavaParser parser) {
      program.initBytecodeReader(reader);
      program.initJavaParser(parser);

      initOptions();
      processArgs(args);

      Collection files = program.options().files();

      if(program.options().hasOption("-version")) {
        printVersion();
        return true;
      }
      if(program.options().hasOption("-help") || files.isEmpty()) {
        printUsage();
        return true;
      }

      try {
        for(Iterator iter = files.iterator(); iter.hasNext(); ) {
          String name = (String)iter.next();
          if(!new File(name).exists())
            System.err.println("WARNING: file \"" + name + "\" does not exist");
          program.addSourceFile(name);
        }

        for(Iterator iter = program.compilationUnitIterator(); iter.hasNext(); ) {
          CompilationUnit unit = (CompilationUnit)iter.next();
          if(unit.fromSource()) {
              unit.crossprocess();
          }
        }
        for(Iterator iter = program.compilationUnitIterator(); iter.hasNext(); ) {
          CompilationUnit unit = (CompilationUnit)iter.next();
            try {
              Collection errors = unit.parseErrors();
              Collection warnings = new LinkedList();
              // compute static semantic errors when there are no parse errors
              // or the recover from parse errors option is specified
              if(errors.isEmpty() || program.options().hasOption("-recover"))
                unit.errorCheck(errors, warnings);
              if(!errors.isEmpty()) {
                processErrors(errors, unit);
                return false;
              }
              else {
               if(!warnings.isEmpty())
                 processWarnings(warnings, unit);
              }
            } catch (Throwable t) {
              System.err.println("Errors:");
              System.err.println("Fatal exception while processing " +
                  unit.pathName() + ":");
              t.printStackTrace(System.err);
              return false;
            }
        }
        for(Iterator iter = program.compilationUnitIterator(); iter.hasNext(); ) {
          CompilationUnit unit = (CompilationUnit)iter.next();
          System.out.println("processNoErrors: " + unit.pathName());
          processNoErrors(unit);
        }
      } catch (Throwable t) {
        System.err.println("Errors:");
        System.err.println("Fatal exception:");
        t.printStackTrace(System.err);
        return false;
      }
      return true;
  }

  protected void processNoErrors(CompilationUnit unit) {
    unit.transformation();
    try {
        String path = new File(unit.pathName()).getCanonicalPath();
        String base = new File(".").getCanonicalPath();
        //System.out.println("base = " + base);
        //System.out.println("path = " + path);
        while(!path.startsWith(base)) {
            base = new File(base).getParent();
            //System.out.println("base = " + base);
            if(base == null)    break;
        }
        if(base != null) {
            path = path.substring(base.length());
            File dir = new File("./_dominoj_output");
            //System.out.println("dir = " + dir.getCanonicalPath());
            if(dir.isDirectory()) {
                File file = new File(dir, path);
                file.getParentFile().mkdirs();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(unit.toString());
                writer.close();
                //System.out.println("output: " + file.getAbsolutePath());
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    unit.generateClassfile();
  }

  protected String name() { return "JastAddJ Java5Compiler + DominoJ"; }
  protected String version() { return "0.2"; }
}
