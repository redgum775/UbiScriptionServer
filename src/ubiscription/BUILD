java_library(
  name = "command",
  srcs = ["Command.java",],
  deps = ["//external:gson",
          "//src/hue:hue",
          ":lighting",],
  visibility = ["//visibility:public"],
)

java_library(
  name = "lighting",
  srcs = ["Lighting.java",],
  visibility = ["//visibility:public"],
)

java_binary(
  name = "server",
  srcs = ["Server.java",],
  main_class = "src/ubiscription/Server",
  deps = [":command",],
)
