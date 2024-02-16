import React from "react";
import Login from "./Login";
import RunningLine from "./RunningLine";

const WelcomeNote =()=>
{


    return(
        <div  /*style={{backgroundImage:"https://artworkbird.co.in/sai-baba-marathi-png/"}} */>
              <div className="ng-binding text-center" style={{color:"maroon"}}>
                <h2>Welcome To Sai Darshan Booking Portal</h2>
               </div>

             <div id="welcomenote" className="text-center">		
                Shri Saibaba Sansthan Trust, Shirdi is pleased to launch of next generation 
                portal for availing Darshan, Aarti, Donation, Accommodation, Pooja and 
                Publications services.
                <br/>
                <RunningLine/>

             </div> 
             <div id="mainImage" /*style={{backgroundImage:"https://artworkbird.co.in/sai-baba-marathi-png/"}}*/>
                <table /*style={{backgroundImage:"https://artworkbird.co.in/sai-baba-marathi-png/"}}*/>
                    <tr>
                        <td>
                        <img src="https://online.sai.org.in/content/images/bitmap@2x.png" width={230} height={360} style={{marginLeft:10}}/>
                
                        </td>
                        <td>
                        <div style={{marginLeft:300}} >
                         <Login/>
                        </div>
                        </td>
                    </tr>
                </table>
                
             </div>

           

                <br/><br/>
        </div>
    )
}

export default WelcomeNote;