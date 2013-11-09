package com.rizvn.methodrouter;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: riz
 * Date: 08/11/2013
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Node {
  String value();
}
