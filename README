The DominoJ compiler
--------------------
Copyright (c) 2011-, YungYu Zhuang. All rights reserved.

DominoJ is a Java-based language supporting method slots,
and this project is an implementation of its compiler built on top of JastAddJ.
For the publications and binary distribution please visit our project webpage:
  http://www.csg.ci.i.u-tokyo.ac.jp/projects/dominoj/

The source code of this project is licensed under the modified BSD License
(please see the LICENSE file for the full text).


build steps:
  1. checkout DominoJ from GitHub.
     "git clone https://github.com/yungyu/dominoj.git dominoj"
  2. checkout JastAddJ from its SVN repository.
     "svn checkout http://svn.cs.lth.se/svn/jastadd-oxford/projects/branches/JastAddJ-stable/ jastaddj"
  2. build DominoJ using ant
     "cd dominoj && ant"

create jar files:
  1. "ant jar" for building DominoJCompiler.jar and dominoj.jar
  2. "ant source" for building dominoj-compiler-src.jar

examples:
  1. "cd examples && ant"
  2. "ant run" for testing

testcases:
  1. "cd testcases && ant"
  2. "ant run" for testing

to compile a source file written in DominoJ:
     "java -jar DominoJCompiler.jar MyClass.java"
  or:
     "java -cp path_of_dominoj JavaCompiler MyClass.java"
  or let dominojc could be found in your $PATH and then:
     "dominojc MyClass.java"

the execution is the same as other Java programs.
     "java -cp dominoj.jar:. MyClass"
