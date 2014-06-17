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

public @interface Dummy {
    boolean value() default true;
}
