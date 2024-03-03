import NavBar from "./NavBar"
import Header from "./Header"


const Common = () =>{
    return(
       <div>
        <div id="div1" style={{ backgroundColor: 'orange'}} className="text-center">
        <img src="https://online.sai.org.in/content/images/shirdi_logo.png" alt=""/> 
        </div>

        <div id = "div2" className="text-center">
        <h2 style={{ color: 'maroon'}}>SHRI SAIBABA SANSTHAN TRUST,SHIRDI</h2>
        </div>
        
        <div>
        <NavBar/>
        </div>
       </div>
    )
}

export default Common;