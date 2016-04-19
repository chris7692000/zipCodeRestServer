<!DOCTYPE html>
<html>
    <head>
        <title>ZIP Code REST</title>
        <script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
        <script>
            $( document ).ready(function()
            {
                $('#singleZipCode').focus();
            });

            function lookupSingleZipCode()
            {
                var zipCode = $('#singleZipCode').val();
                var singleURL = '${pageContext.request.contextPath}/rest/zipcodes/single/' + zipCode;
                window.open(singleURL, '_blank');
            }

            function lookupState()
            {
                var stateCode = $('#stateCode').val();
                var stateURL = '${pageContext.request.contextPath}/rest/zipcodes/state/' + stateCode;
                window.open(stateURL, '_blank');
            }
        </script>
    </head>
    <body>

    <h1>U.S. Zip Code REST Server</h1>
    <h2>Get information about a single U.S. zip code:</h2>
    <i>${pageContext.request.method}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/rest/zipcodes/single/ZIPCODE</i>
    <br/>
        <label for="singleZipCode">U.S. Zip Code:</label>
        <input id="singleZipCode" type="text" size="5" maxlength="5" value=""/>
        <button type="button" onclick="lookupSingleZipCode();">Lookup</button>
    <br/>

    <h2>Get information about all zip codes in a U.S. state.</h2>
    <i>http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/rest/zipcodes/state/STATE</i>
    <br/>
    <label for="stateCode">U.S. State:</label>
    <input id="stateCode" type="text" size="2" maxlength="2" value=""/>
    <button type="button" onclick="lookupState();">Lookup</button>
    <br/>


    </body>
</html>