import React from "react"
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function Header()
{
    

    return(
        <div>
            <div id = "div2" className="text-center"  style={{backgroundImage:"https://artworkbird.co.in/sai-baba-marathi-png/"}}>
            <h2 style={{ color: 'maroon'}}>SHRI SAIBABA SANSTHAN TRUST,SHIRDI</h2> 
            </div>

           
        </div>

        
    )
}


export default Header;