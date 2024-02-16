import './App.css';
import Home from './components/Home';
import {Routes,Route, BrowserRouter } from 'react-router-dom';
import NotFound from './components/NotFound';
import Copyright from './components/Copyright';
import Registration from './components/Registration';
import ContactUs from './components/ContactUs';
import Darshan from './components/Darshan';
import Arti from './components/Arti';
import Pooja from './components/Pooja';
import Accomodation from './components/Accomodation';
import TandC from './components/TandC';
import Feedback from './components/Feedback';
import Faq from './components/Faq';
import SignUp from './components/Signup';
import Admin from './components/AdminComponent/Admin'
import AllPooja from './components/AdminComponent/AllPooja';
import AllAccomodation from './components/AdminComponent/AllAccomodation';
import AllUsers from './components/AdminComponent/AllUsers';
import AllDarshan from './components/AdminComponent/AllDarshan';
import AllArti from './components/AdminComponent/AllArti';



function App() {

  return (
    <BrowserRouter>
    <div>
     
        <Routes>
          <Route exact path="/admin" element={<Admin/>}>
            <Route exact path="allpooja" element={<AllPooja/>}/>
            <Route exact path="allarti" element={<AllArti/>}/>
            <Route exact path="alldarshan" element={<AllDarshan/>}/>
            <Route exact path="allaccomodation" element={<AllAccomodation/>}/>
            <Route exact path="allusers" element={<AllUsers/>}/>
          </Route>
          

          <Route exact path="/" element={<Home/>} />
          <Route exact path="/home" element={<Home/>} /> 
          <Route exact path="/copyright" element={<Copyright/>} />
          <Route exact path="/accomodation" element={<Accomodation/>} /> 
          <Route exact path="/darshan" element={<Darshan/>} /> 
          <Route exact path="/arti" element={<Arti/>} /> 
          <Route exact path="/pooja" element={<Pooja/>} /> 
          <Route exact path="/contactus" element={<ContactUs/>} /> 
          <Route exact path="/login" element={<Home/>} />  
          <Route exact path ="/signup" element={<SignUp/>}/>
          <Route exact path="/faq" element={<Faq/>} /> 
          <Route exact path="/feedback" element={<Feedback/>} /> 
          <Route exact path="/tandc" element={<TandC/>} /> 
          <Route path="*" element={<NotFound/>} />
          
        </Routes>
     
    </div>
    </BrowserRouter>
  );
}

export default App;
