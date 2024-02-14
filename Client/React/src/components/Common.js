
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
        <nav className="navbar navbar-expand-lg navbar-light bg-light justify-content-center   ">
      <div className="container-fluid">
        <div className="collapse navbar-collapse justify-content-center" id="navbarNav"  >
          <ul className="navbar-nav">
            
            <li className="nav-drashan">
              <a className="nav-link" href="/home">Home</a>
            </li>


            <li className="nav-drashan">
              <a className="nav-link" href="/darshan">Darshan</a>
            </li>
            
            <li className="nav-arti">
              <a className="nav-link" href="/arti">Arti</a>
            </li>

            <li className="nav-pooja">
              <a className="nav-link" href="/pooja">Pooja</a>
            </li>

            <li className="nav-accomodation">
              <a className="nav-link" href="/accomodation">Accomodation</a>
            </li>
    
          </ul>
        </div>
      </div>
      </nav>
        </div>
       </div>
    )
}

export default Common;