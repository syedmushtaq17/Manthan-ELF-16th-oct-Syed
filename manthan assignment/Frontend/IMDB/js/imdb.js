function getdata(){
  
    mov=document.getElementById("search").value;
    console.log(mov)
    tsr=""
    // fetches response from given link and MOvie Name ;
    fetch("http://www.omdbapi.com/?s="+mov+"&apikey=d6f86dbc")
    // convert json file  to object
    .then(response => response.json())
    .then(json =>{

        per=json
        console.log(per.Search )
        for(x in per.Search){
            console.log(per.Search[x].Title);
            tsr=tsr+"<img src='"+per.Search[x].Poster+"' class='card-img-top' alt='img'>"+
            "<div class='card-body'>"+
            "<h5 class='card-title'>"+per.Search[x].Title+"</h5>"+
            "<h5 class='card-title'>"+per.Search[x].Year+", "+per.Search[x].imdbID+"</h5>"+
            "<a href='#' class='btn btn-primary'>Watch</a></div><hr> <hr> <hr> <hr>"
            document.getElementById("carddiv").innerHTML=tsr
        }
        //document.getElementById("carddiv").innerHTML=tsr
    })
    .catch(err=>console.log(err))

}