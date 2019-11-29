//function to perform count down after getting the time from start function()

 function startTimer(duration, display) {
    var timer = duration, minutes, seconds;
    // this one sets a delay of 1 secs and will keep on continuing .
    setInterval(function () {
        // for making minutes and seconds out of the given number
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;
    // its a kind of stopping condition 
        if (--timer < 0) {

            // to give an alert to user
            window.alert("Timer Finished")
            timer = duration;
            // it will close the interval else it will keep on repeaing for the given value
            clearInterval()
        }
    }, 1000);
}

//function to start  the counter i.e start button 
  function start ( ) {
  /// it will fetch the given time 
      var inn=document.getElementById("in").value;

    var fiveMinutes = 60 * inn,
        display = document.querySelector('#time');
    startTimer(fiveMinutes, display);
};