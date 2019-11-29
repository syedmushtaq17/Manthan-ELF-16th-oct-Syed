function compile() {
 //fetches HTML code
    var html = document.getElementById("html");
     //fetches CSS code
    var css = document.getElementById("css");
     //fetches JS code
    var js = document.getElementById("js");
     //fetches content code
    var code = document.getElementById("code").contentWindow.document;

    document.body.onkeyup = function() {
        code.open();
        code.writeln(html.value + "<style>" + css.value + "</style>" + "<script>" + js.value + "</script>");
        code.close();
    };
};

compile();