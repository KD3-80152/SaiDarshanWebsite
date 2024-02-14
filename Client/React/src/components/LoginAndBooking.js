import React from "react";




const LoginAndBooking =()=>
{
    return(

        <div class="row" style={{margin:'auto'}}>
            <div className="col-sm-6">
                <div className="card" style={{padding:6,color:"white", backgroundColor:"red"}}><b>LoginAndBooking Process</b></div>
                <div className="container2">

                    <div>
                        <div>Devotee Can Login with Either Mobile Number And OTP/Password
                            or Email ID and Password.
                        </div>
                    </div>

                    <div>
                        <div>
                            Same Mobile number or Email ID used for Creating an Account Cannot 
                            be Used for Different accounts.
                        </div>
                    </div>

                    <div>
                        <div>
                            After Login , Devotee should update their personal details - Name,
                            Age, ID Proof to Book service.
                        </div>
                    </div>

                    <div>
                        <div>
                            Details of any one of the Photo IDs - Aadhar Card / Voter ID/PAN Card
                            /PASSPORT/RATION CARD/DL to be entered which will be verified at Shirdi
                            while availing services.
                        </div>
                    </div>

                    <div>
                        <div>
                            Email ID should be Updated in My Profile, If Devotee wants to login/to be
                            communicated through Email. Email ID is mandatory.
                        </div>
                    </div>

                    <div>
                        <div>
                            Once Devotee Updates the Email in My Profile , a verification link will be sent for
                            Email Validation.
                        </div>
                    </div>

                    <div>
                        <div>
                            Without Login devotee can ONLY find the availability of service.
                        </div>
                    </div>

                    <div>
                        Devotee who does not have access to Mobile/OTP services can click 
                        on 
                        <a href="/registration" className="footer-links" tabIndex={"6"}
                            > Register</a> .
                    </div>

                </div>
            </div>

            <div className="col-sm-6 heading-1">
                <div className="card" style={{padding:6,color:"white", backgroundColor:"red"}}><b>Latest Updates</b></div>

                <div className="container2">
                    <div>
                        <div className="log-bul-cont-here" style={{marginLeft:-5}}>
                            Relaxed registration process and Introduced Simplified Login Process
                            for Devotee to login with either Mobile Number and OTP/password.

                            <div style={{animation :"blink 1s infinite"}}>
                                NEW
                            </div>
                        </div>
                    </div>

                    <div style={{textAlignLast:"start"}}>
                        <ul style={{listStyle:"none",paddingLeft:10,float:"left"}}>
                            <li style={{marginLeft:-20, textAlign:"justify"}} className="bul ng-scope">
                                <div className="log-bul-cont-here ng-binding">
                                Shri Saibaba Diary 2024 (Marathi-English) and Shri Saibaba Calendar (1 page) are now available in Online Website 
                                and also Shirdi Local Books Counters and Dadar,MumbaiOffice.
                                </div>
                            </li>

                            <li style={{marginLeft:-20, textAlign:"justify"}} className="bul ng-scope">
                                <div className="log-bul-cont-here ng-binding">
                                Shri Saibaba Diary 2024 (Marathi-English) and Shri Saibaba Calendar (1 page) are now available in Online Website 
                                and also Shirdi Local Books Counters and Dadar,MumbaiOffice.
                                </div>
                            </li>

                            <li style={{marginLeft:-20, textAlign:"justify"}} className="bul ng-scope">
                                <div className="log-bul-cont-here ng-binding">
                                Quota for Paid Darshan, Aarti, Pooja and Accomodation will be released prior 30 days.
                                </div>
                            </li>


                            <li style={{marginLeft:-20, textAlign:"justify"}} className="bul ng-scope">
                                <div className="log-bul-cont-here ng-binding">
                                Sai devotees can book Aarti for maximum of 4 persons per booking.
                                </div>
                            </li>


                            <li style={{marginLeft:-20, textAlign:"justify"}} className="bul ng-scope">
                                <div className="log-bul-cont-here ng-binding">
                                Sansthan does not authorize any agents for online bookings of 
                                Darshan / Aarti / Accommodation / Donations / Membership / Publications.
                                </div>
                            </li>


                            <li style={{marginLeft:-20, textAlign:"justify",color:"red"}} className="bul ng-scope">
                                <div className="log-bul-cont-here ng-binding">
                                Beware...! Never share Debit/Credit Card/Account details, 
                                ATM PIN, Passwords, CVV, OTP over phone/email. Sansthan never asks for such details.
                                </div>
                            </li>

                        
                        </ul>
                    </div>

                </div>
            </div>

        </div>
    )
}

export default LoginAndBooking;