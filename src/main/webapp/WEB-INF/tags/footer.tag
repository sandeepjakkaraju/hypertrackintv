<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- Placed at the end of the document so the pages load faster --%>
<spring:url value="/vendors/jquery/jquery.min.js" var="jQuery"/>
<script src="${jQuery}"></script>


<%-- jquery-ui.js file is really big so we only load what we need instead of loading everything --%>
<spring:url value="/vendors/jquery-ui/ui/jquery-ui.js" var="jQueryUi"/>
<script src="${jQueryUi}"></script>

<%-- jquery-ui.js file is really big so we only load what we need instead of loading everything --%>
<spring:url value="/vendors/jquery-ui/ui/jquery.ui.core.js" var="jQueryUiCore"/>
<script src="${jQueryUiCore}"></script>

<spring:url value="/vendors/jquery-ui/ui/jquery.ui.datepicker.js" var="jQueryUiDatePicker"/>
<script src="${jQueryUiDatePicker}"></script>


<spring:url value="/vendors/jquery-ui/ui/jquery.ui.widget.js" var="jQueryUiWidget"/>
<script src="${jQueryUiWidget}"></script>

<spring:url value="/vendors/jquery-ui/ui/jquery.ui.autocomplete.js" var="jQueryUiAutoComplete"/>
<script src="${jQueryUiAutoComplete}"></script>


<%-- Bootstrap --%>
<spring:url value="/vendors/bootstrap/dist/js/bootstrap.min.js" var="bootstrapJs"/>
<script src="${bootstrapJs}"></script>

