<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clother</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/assets/css/styles.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css"/>

</head>

<body style="font-size:25px;background-image:url(/static/assets/img/mountain_background.jpg);background-size:cover;">
<nav class="navbar navbar-light navbar-expand-md navigation-clean-search"
     style="background-color:rgba(37,37,37,0.5);color:rgb(255,255,255);">
    <div class="container">
        <a class="navbar-brand text-light" href="/">Clother</a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse"
             id="navcol-1">
            <ul class="nav navbar-nav"></ul>
            <select data-live-search="true" data-live-search-style="startsWith"
                    class="selectpicker" name="citiesSelect"
                    onchange="document.location = this.options[this.selectedIndex].value">
                <option value="Odessa">Odessa</option>
                <option value="Lviv">Lviv</option>
                <option value="Kiev">Kiev</option>
                <option value="Los Angeles">Los Angeles</option>
                <option value="London">London</option>
                <option value="Moscow">Moscow</option>
                <option value="New York">New York</option>
                <option value="San Francisco">San Francisco</option>
                <option value="Milan">Milan</option>
                <option value="Chacago">Chicago</option>
            </select>
        </div>
    </div>
</nav>
<div>
    <div class="container flex-row">
        <div class="row" style="padding:25px;">
            <div class="col-md-8 col-lg-9" style="padding:25px;background-color:rgba(37,37,37,0.5);height:682px;">
                <div class="d-flex flex-row flex-fill justify-content-between align-items-center align-content-center"
                     style="overflow: visible">
                    <div class="d-flex flex-column flex-fill justify-content-between" style="width:390px;height:631px;">
                        <div class="d-flex flex-column" style="margin-bottom:50px;">
                            <h3 class="text-light">Hourly</h3>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="d-flex flex-row justify-content-between align-items-between align-content-center"
                                     id="hourly">
                                    <#list hourlies as hour>
                                        <div class="d-flex flex-column align-items-center justify-content-between">
                                            <p class="text-light">${hour.getTime()}</p>
                                            <img src="/static/assets/img/icons/${hour.getIcon()}.png" width="70px"
                                                 alt="${hour.getIcon()}">
                                            <p class="text-light">${hour.getTemperature()}ºC</p>
                                        </div>
                                    </#list>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex flex-column">
                            <h3 class="text-light">Daily</h3>
                            <div class="d-flex flex-column justify-content-between align-items-stretch align-content-center"
                                 id="daily">
                                <#list daily as day>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <p class="text-light" style="width: 70px">${day.getTime()}</p>
                                        <img src="/static/assets/img/icons/${day.getIcon()}.png" width="35px"
                                             alt="${day.getIcon()}">
                                        <p class="text-light">${day.getPrecipProbability() * 100}%</p>
                                        <div class="d-flex justify-content-between" style="width: 70px">
                                            <p class="text-light">${day.getTemperatureHigh()}↑</p>
                                            <p class="text-light">${day.getTemperatureLow()}↓</p>
                                        </div>
                                    </div>
                                </#list>
                            </div>
                        </div>
                    </div>
                    <div class="d-flex flex-column justify-content-center" style="margin-left:60px;height:630px;"><img
                            src="/static/assets/img/humans/cold.png" style="width:130px;"></div>
                </div>
            </div>
            <div class="col-md-4 col-lg-3" style="height:682px;background-color:rgba(37,37,37,0.5);padding:10px;">
                <h1 class="text-center text-light">Odessa</h1>
                <p class="text-center text-light">${currently.getTime()}</p>
                <h1 class="text-center text-light" style="font-size:100px;">${currently.getTemperature()}º</h1>
                <p class="text-center text-light">Feels like ${currently.getApparentTemperature()}º</p>
                <p class="text-center text-light">${currently.getSummary()}</p>
                <p class="text-center text-light">${currently.getPressure()}</p>
                <p class="text-center text-light">${currently.getWindSpeed()}</p>
                <p class="text-center text-light">${daily.get(0).getSunriseTime()}</p>
                <p class="text-center text-light">${daily.get(0).getSunsetTime()}</p>

            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.0/js/bootstrap.bundle.min.js"></script>
</body>

</html>