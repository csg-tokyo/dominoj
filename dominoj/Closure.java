package dominoj;

import java.io.Serializable;
import java.util.HashSet;

public abstract class Closure implements Serializable {
    public Object exec(Object[] args) throws Exception { return null; }
    public HashSet writers() { return new HashSet(); }
}

