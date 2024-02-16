import React from "react";
import Header from "./Header";
import FooterNav from "./FooterNav";
import LoginAndBooking from "./LoginAndBooking";
import Navbar from "./NavBar";
import WelcomeNote from "./WelcomeNote";


const Home = () =>
{
    return(

        <div>

            <div id="div1" style={{ backgroundColor: 'orange', backgroundImage:"https://artworkbird.co.in/sai-baba-marathi-png/"}} className="text-center">
            <img src="https://online.sai.org.in/content/images/shirdi_logo.png" alt=""/> 
            </div>



            <div>
            <Header/>
            </div>
            
            <div>
            <Navbar/>
            </div>

            <div>
            <WelcomeNote/>
            </div>

            <div>
            <LoginAndBooking/>
            </div>


            <div>
            <FooterNav/>
            </div>

    </div>

    )
}

export default Home;