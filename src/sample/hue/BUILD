java_binary(
  name = "sample",
  srcs = ["Sample.java",],
  main_class = "src/sample/hue/Sample",
  deps = [":hue",],
)

java_binary(
  name = "gui_sample",
  srcs = ["GUISample.java",],
  main_class = "src/sample/hue/GUISample",
  deps = [":hue",],
)

java_library(
  name = "hue",
  srcs = ["Hue.java",],
  deps = ["//external:gson",
          "//src/sample/hue/state:state",],
  visibility = ["//visibility:public"],
)