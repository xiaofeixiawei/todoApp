package com.manning.gia.todo

class ProjectVersion {
    Integer major
    Integer minor
    Boolean release

    @Override
    String toString() {
        return "$major.$minor${release ? '' : '-SNAPSHOT'}"
    }
}
