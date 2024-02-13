
import React from 'react'
import Home from './Home'
import Registration from './Registration'
import Login from './Login'
import NotFound from './NotFound'
import './app.css';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
// import {Link, Route, Switch} from 'react-router-dom';
import { Routes, Route, Link } from 'react-router-dom';


// function Launcher()
// {
//   return
//   (
//     <div className="container">
//       <Switch>
//         <Route exact path='/' element={<Home />} />
//         <Route exact path='/registration' element={<Registration />} />
//         <Route exact path='/login' element={<Login />} />
//         <Route path = '**' element={NotFound} />
//     </Switch>
//     </div>
//   )
// }









const Launcher = () => {
  return (
    <div className = "background">
    <div className="container ">
      {/* <Router> */}
      <hr />
      <Link to = "/home">Home</Link> {" | "}
      <Link to = "/login">Login</Link> {" | "}
      <Link to = "/registration">Registration</Link> {" | "}

      <hr />

      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route exact path="/home" element={<Home />} />
        <Route exact path="/login" element={<Login />} />
        <Route exact path="/registration" element={<Registration />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
      {/* </Router> */}
    </div>
    </div>
  )
}

export default Launcher























// import Home from './Home'
// import Registration from './Registration'
// import Login from './Login'


// import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
// import {BrowseRouter, Routes, Route} from 'react-router-dom'



// function Launcher() 
// {
//   return (
//     <BrowseRouter>
//       <Routes>
//         <Route path = '/' elements = {<Home />} />
//         <Route path = '/registration' elements = {<Registration />} />
//         <Route path = '/login' elements = {<Login />} />
//       </Routes>
//     </BrowseRouter>
//   );
// }

// export default Launcher;
