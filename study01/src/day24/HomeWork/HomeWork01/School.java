package day24.HomeWork.HomeWork01;

import java.io.Serializable;

/**
 *
 */

public class School implements Serializable, Comparable<School> {
    private static final long serialVersionUID = 1L;
    private static String school = "山东财经大学";
    private String className;

    public School(String className) {
        this.className = className;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "School{" +
                "school='" + school + '\'' +
                ", className='" + className + '\'' +
                '}';
    }

    public String getSchool() {
        return school;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public School() {
    }

    @Override
    public int compareTo(School o) {
        return this.getClassName().compareTo(o.getClassName());
    }
}