package by.vorakh.dev.data_structure.unit1.task1

import spock.lang.Specification

class BracketsCheckerFeature extends Specification {

    def "check of #brackets is #answer"() {

        expect:
            BracketsChecker.check(brackets) == answer

        where:
            brackets      || answer
            "[]"          || "Success"
            "{}[]"        || "Success"
            "[()]"        || "Success"
            "(())"        || "Success"
            "{[]}()"      || "Success"
            "{"           || "1"
            "}"           || "1"
            "{[}"         || "3"
            "foo(bar);"   || "Success"
            "foo(bar[i);" || "10"
            "]()"         || "1"
            "()[}"        || "4"
            "()[]}"       || "5"
            "{}([]"       || "3"
    }

    def "check V2 of #brackets is #answer"() {

        expect:
            BracketsChecker.checkV2(brackets) == answer

        where:
            brackets      || answer
            "[]"          || "Success"
            "{}[]"        || "Success"
            "[()]"        || "Success"
            "(())"        || "Success"
            "{[]}()"      || "Success"
            "{"           || "1"
            "}"           || "1"
            "{[}"         || "3"
            "foo(bar);"   || "Success"
            "foo(bar[i);" || "10"
            "]()"         || "1"
            "()[}"        || "4"
            "()[]}"       || "5"
            "{}([]"       || "3"
    }
}