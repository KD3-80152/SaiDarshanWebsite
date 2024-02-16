
import Content from "./Content";
import axios from "axios";
import { useEffect, useState } from "react";




const Admin =()=>{

    // const getAllPooja =()=>{
    //     axios.get("https://localhost:8443/allpooja").then(
    //         (response)=>{
    //             //For Success

    //         },
    //         (error)=>{
    //             //For Failure

    //         }
    //     )
    // };

    // useEffect(()=>{
    //     getAllPooja();
    // },[]);


    // const [pooja,setPooja] = useState([]);



    return(
        <div id="adminmain">

            <div>

                <div>
                    <div id="div1" style={{ backgroundColor: 'orange'}} className="text-center">
                    <img src="https://online.sai.org.in/content/images/shirdi_logo.png" alt=""/> 
                    </div>
                </div>
            
                <div id = "div2" className="text-center" >
                    <h2 style={{ color: 'maroon'}}>SHRI SAIBABA SANSTHAN TRUST,SHIRDI</h2> 
                </div>

                <div>
                   <div className="row">
                    <Content/>
                   </div>
                </div>
            </div>

            

        </div>
)}


export default Admin;