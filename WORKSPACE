load("@bazel_tools//tools/build_defs/repo:jvm.bzl", "jvm_maven_import_external")

# JSON
# useing //external:gson
jvm_maven_import_external(
    name = "gson_maven",
    artifact = "com.google.code.gson:gson:2.8.7",
    server_urls = ["https://repo1.maven.org/maven2/"],
)

bind(
    name = "gson",
    actual = "@gson_maven//jar",
)

# jfreechart
# useing //external:jfreechart
jvm_maven_import_external(
    name = "jfreechart_maven",
    artifact = "org.jfree:jfreechart:1.5.0",
    server_urls = ["https://repo1.maven.org/maven2/"],
)

bind(
    name = "jfreechart",
    actual = "@jfreechart_maven//jar",
)

# hue_light
# useing //external:hue_light
#jvm_maven_import_external(
#    name = "hue_light_maven",
#    artifact = "org.jenkins-ci.plugins/hue-light:1.2.0",
#    server_urls = ["https://repo1.maven.org/maven2/"],
#)

#bind(
#    name = "hue_light",
#    actual = "@hue_light_maven//jar",
#)