function Sobolev() {
    var Hlder = document.getElementById("Hlder");
    var crit = document.getElementById("crit");
    var critdisplay = document.getElementById("critt");
    var t = document.getElementById("t");
    var bounded = document.getElementById("bnded").checked;
    var f = document.getElementById("f");
    var errorr = document.getElementById("errorr");
    var integinput = document.getElementById("integinput").value;
    var smoothinput = document.getElementById("smoothinput").value;
    var integoutput = document.getElementById("integout").value;
    var smoothoutput = document.getElementById("smoothout").value;
    var Dim = document.getElementById("Dim").value;
    var hhh = smoothinput*integinput;
    var inter1 = 1/integinput;
    var inter2 = smoothoutput-smoothinput;
    var inter3 = -inter2/Dim;
    var inter = inter1-inter3;
    critdisplay.style.display = "none";
    errorr.style.display = "none";
    f.style.display = "none";
    t.style.display = "none";
    if (Hlder.checked == true && Dim<hhh){
      t.style.display = "block";
    }
    else if (Hlder.checked == true){
        f.style.display = "block";
      }
      else{
        if(crit.checked == true){

            if(inter>0){
                document.getElementById("outcrit").innerHTML = 1/(inter);
                critdisplay.style.display = "block";
            }
            else {
                errorr.style.display = "block"
            }
        }
        else{
            if(smoothoutput>smoothinput){
                f.style.display = "block";
            }
            else if(inter<=1/integoutput && bounded && smoothoutput<smoothinput){
                t.style.display = "block";
                
            }
            else if(bounded && smoothoutput==smoothinput && integoutput<=integinput){
                t.style.display = "block";
            }
            else if(smoothoutput<=smoothinput && integoutput==integinput){
                t.style.display = "block";
            }
            else{
                f.style.display = "block";
            }
        }
      }
  }