<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html ng-app="schedulerApp">
<head>
    <title>Allway Tickets PRO | Trains</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>




    <link href="https://cdnjs.cloudflare.com/ajax/libs/datepicker/0.5.3/datepicker.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="<spring:url value="/resources/bower_components/jquery-timepicker-jt/jquery.timepicker.css"/>" rel="stylesheet" type="text/css" media="screen" />
    <link href="<spring:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.css"/>" rel='stylesheet' type='text/css'/>
    <link href="<spring:url value="/resources/css/jquery-ui.min.css"/>" rel='stylesheet' type='text/css'/>
    <link href="<spring:url value="/resources/css/style.css"/>" rel='stylesheet' type='text/css'/>

    <script src="<spring:url value="/resources/bower_components/jquery/dist/jquery.js"/>"></script>
    <script src="<spring:url value="/resources/bower_components/angular/angular.js"/>"></script>
    <script src="<spring:url value="/resources/bower_components/angular-route/angular-route.js"/>"></script>
    <script src="<spring:url value="/resources/bower_components/jquery-timepicker-jt/jquery.timepicker.js"/>"></script>
    <script src="<spring:url value="/resources/bower_components/angular-mocks/angular-mocks.js"/>"></script>
    <script src="<spring:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.js"/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/datepicker/0.5.3/datepicker.js"></script>




    <script src="<spring:url value="/resources/js/util/timepickerdirective.js"/>"></script>
    <script src="<spring:url value="/resources/js/util/jquery-ui.min.js"/>"></script>
    <script src="<spring:url value="/resources/js/util/ui-bootstrap-tpls-2.5.0.js"/>"></script>

    <script src="<spring:url value="/resources/js/app.js"/>"></script>
    <script src="<spring:url value="/resources/js/global-routes.js"/>"></script>
    <script src="<spring:url value="/resources/js/http-factories.js"/>"></script>
    <script src="<spring:url value="/resources/js/stations.js"/>"></script>
    <script src="<spring:url value="/resources/js/trains-by-route.js"/>"></script>
    <script src="<spring:url value="/resources/js/trains-by-station.js"/>"></script>



</head>
<body>

<!-- banner -->
<jsp:include page="fragments/headerBody.jsp"/>


<!-- banner-->

<div id="search" class="searh_panel " ng-controller="schedulerCtrl" >
    <div class="container" style="margin-top: 5%;">
        <div class="col-md-12 ">


            <!-- FORM-->


            <div id="homepage-search" class="tabs clearfix"  >
                <ul class="for-tabs">
                    <li ng-class="{active: showTab1}" ng-click= "swapToTab1()"><a href="" >Trains by the route</a></li>
                    <li ng-class="{active: showTab2}" ng-click="swapToTab2()"><a href="" >Trains by the station</a></li>

                </ul>

                <!-- TAB-1-->

                <div ng-show="showTab1" id="tab-1" class="tab-content" >

                    <form class="route">
                        <div class="clearfix">
                            <div  class="form-column column-from">

                                <%--<input type="text" ng-model="st"  typeahead-editable="false"--%>
                                       <%--typeahead="st for st in sts | filter:$viewValue"--%>
                                       <%--ng-blur="blur($viewValue)" typeahead-select-on-blur="true" />{{from}}--%>


                                    <input name="from_st" ng-model="routeParams.from" type="text"
                                           class="place" placeholder="From Station"
                                           uib-typeahead="state for state in sts | filter:$viewValue | limitTo:8">
<%--
                                <input name="from_st" ng-model="routeParams.from" type="text"
                                       class="place" placeholder="From Station"
                                       data-required="Enter the station"  >--%>


                            </div>
                            <div id="reverce"></div>
                            <div class="form-column column-to">

                                <input  name="to_st" ng-model="routeParams.to" type="text"
                                       class="place" placeholder="To Station"
                                        uib-typeahead="state for state in sts | filter:$viewValue | limitTo:8" >
                            </div>

                            <div class="form-column column-when">
                                <input name="dateP" type="text" value=""
                                       class="date datepicker " placeholder="When" ng-model="routeParams.dateP1"
                                       datepickerer>
                            </div>
                        </div>

                        <div ng-show="showAdvanced1" class="advanced advanced1 clearfix">
                        <div class="advanced_column advanced_column1">
                            <p>Time departure:</p>


                            <p>From
                                <input type="text" class="time" ng-model="advancedElem.timeFrom1" ui-timepicker="options" />
                                To
                                <input type="text" class="time" ng-model="advancedElem.timeTo1"  ui-timepicker="options" />
                            </p>


                        </div>

                        <div  class="advanced_column advanced_column2">
                            <p>Train type:</p>
                            <label>
                                <input type="checkbox" ng-model="advancedElem.checkboxModel.high"> HIGH_SPEED:
                            </label><br/>
                            <label>
                                <input type="checkbox" ng-model="advancedElem.checkboxModel.fast"> FAST:
                            </label><br/>
                            <label>
                                <input type="checkbox" ng-model="advancedElem.checkboxModel.passenger"> PASSENGER:
                            </label><br/>
                        </div>
                    </div>

                        <div class="tab_bottom clearfix">
                            <div class="trigger_advanced_container" ng-click="showAdvanced1=!showAdvanced1">
                                <span class="trigger_advanced" id="trigger_advanced_1">Advanced Search</span>
                            </div>
                            <div  class="submit_container" >
                                <a href="#!/train-search-by-route/{{routeParams.from}} -- {{routeParams.to}}/{{routeParams.dateP1}}"> <input type="submit" value="Find"
                                                    class="submit_search" ng-click="findByRoute()"></a>
                               </div>
                        </div>
                    </form>
                </div>

                <!-- TAB-2-->

                <div ng-show="showTab2" id="tab-2" class="tab-content" >

                    <form class="station">
                        <div class="clearfix">
                            <div class="form-column column-station">
                                <input type="text" ng-model="routeParams.station"
                                       class="place " placeholder="From Station"
                                       uib-typeahead="state for state in sts" ></div>

                            <div class="form-column column-st_date">
                                <input type="text" value=""
                                       class="date datepicker " placeholder="When" ng-model="routeParams.dateP2"
                                       datepickerer>
                            </div>
                        </div>

                        <div ng-show="showAdvanced2" class="advanced advanced2 clearfix">
                            <div class="advanced_column advanced_column1">
                                <p>Time departure:</p>
                                <p>From
                                    <input type="text" class="time " ng-model="advancedElem.timeFrom2" ui-timepicker="options">
                                    To
                                    <input type="text" class="time " ng-model="advancedElem.timeTo2" ui-timepicker="options">
                                </p>
                            </div>
                            <div  class="advanced_column advanced_column2">
                                <p>Train type:</p>
                                <label>
                                    <input type="checkbox" ng-model="advancedElem.checkboxModel.high"> HIGH_SPEED:
                                </label><br/>
                                <label>
                                    <input type="checkbox" ng-model="advancedElem.checkboxModel.fast"> FAST:
                                </label><br/>
                                <label>
                                    <input type="checkbox" ng-model="advancedElem.checkboxModel.passenger"> PASSENGER:
                                </label><br/>

                            </div>
                        </div>

                        <div class="tab_bottom clearfix">
                            <div class="trigger_advanced_container" >
                                <span ng-click="showAdvanced2=!showAdvanced2" class="trigger_advanced" id="trigger_advanced_2">Advanced Search</span>
                            </div>
                            <div class="submit_container" ><%--ng-click="findFromStation()"--%>

                                <a href="#!/train-search-by-station/{{routeParams.station}}/{{routeParams.dateP2}}">  <input type="submit" value="Find"
                                                                            class="submit_search"></a></div>
                        </div>
                    </form>
                </div>

            </div>



            <div ng-view></div>

        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

