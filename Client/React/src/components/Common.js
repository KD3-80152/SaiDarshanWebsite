import { toast } from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import "react-toastify/dist/ReactToastify.css";
import LoginNavbar from "./UserComponent/LoginNavBar";
import { isCompositeComponent } from 'react-dom/test-utils';


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
        <LoginNavbar/>
        </div>

        
       </div>
    )
}

export default Common;