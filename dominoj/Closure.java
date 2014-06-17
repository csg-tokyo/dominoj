/*
 * DominoJ is an extension to Java for supporting method slots,
 * and this project is an implementation of its compiler built on top of JastAddJ.
 * 
 * Copyright (c) 2011-, YungYu Zhuang. All rights reserved.
 *
 * The contents of this file are licensed under the modified BSD License
 * (please see the LICENSE file for the full text).
 */

package dominoj;

import java.io.Serializable;
import java.util.HashSet;

public abstract class Closure implements Serializable {
    public Object exec(Object[] args) throws Exception { return null; }
    public HashSet writers() { return new HashSet(); }
}

