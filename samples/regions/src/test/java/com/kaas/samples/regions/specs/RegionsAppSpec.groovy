package com.kaas.samples.regions.specs

import groovyx.net.http.RESTClient
import spock.lang.Specification


class RegionsAppSpec extends Specification {

    RESTClient restClient = new RESTClient("http://localhost:8080")

    def "Obtain provinces of Madrid county"() {
        given:
        String county = "Madrid"

        when:
        def response = restClient.get(path: '/regions', query: ['q': county])

        then:
        response.status == 200

        and:
        response.responseData.name == "Madrid"
    }
}
