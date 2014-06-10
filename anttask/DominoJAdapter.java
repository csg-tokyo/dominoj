package anttask;

import org.apache.tools.ant.taskdefs.compilers.DefaultCompilerAdapter;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.Commandline;

public class DominoJAdapter extends DefaultCompilerAdapter {

  public boolean execute() throws BuildException {
    attributes.log("Using DominoJ compiler", Project.MSG_INFO);
    Commandline cmd = setupJavacCommand();
    String exec = getJavac().getExecutable();
    cmd.setExecutable(exec == null ? "dominojc" : exec);
    int firstFileName = cmd.size() - compileList.length;

    return executeExternalCompile(cmd.getCommandline(), firstFileName)==0;
  }

}

