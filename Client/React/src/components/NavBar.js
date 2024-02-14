import React from "react";

const Navbar = () => {
  return (
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
  );
};

export default Navbar;
