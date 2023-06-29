package com.example.togglzdemo;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

public enum DemoFeatures implements Feature {

  @Label("discount applied")
  DISCOUNT_APPLIED

}

