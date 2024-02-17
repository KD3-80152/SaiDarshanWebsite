import { useState } from "react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";


const Login = () => {
    
  useEffect(()=>{
    document.title="Login";
  },[]);
   
    let navigate = useNavigate();

   

    const [loginRequest, setLoginRequest] = useState({
        email: "",
        password: "",
        
      });

    const [role,setRole]=useState("");
    
      const handleUserInput = (e) => {
        setLoginRequest({ ...loginRequest, [e.target.name]: e.target.value });
      };
    
      const loginAction = (e) => {
        fetch("https://localhost:8443/users/signin", {
          method: "POST",
          headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
          },
          body: JSON.stringify(loginRequest),
        })
          .then((result) => {
            console.log("result", result);
            result.json().then((res) => {
              console.log(res.mesg);
              
              console.log(role);
              if (res.mesg === "ROLE_ADMIN")  /* Write Code  For Admin To Route  */
              {
                console.log("Got the success response");
                
              
             
    
                if (res.jwt != null) {
                  sessionStorage.setItem("jwtToken", res.jwt);
                  
                }
    
                if (res.jwt !== null) {
                  toast.success(res.mesg, {
                    position: "top-right",
                    autoClose: 3000,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                  });
                  setTimeout(() => {
                    window.location.href = "/pooja";
                     
                  }, 5000); 
                } else {
                  toast.error(res.mesg, {
                    position: "top-right",
                    autoClose: 3000,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                  });
                }
              
              }
              else /* Write Code  For User To Route  */
              {

              }



            });
          })
          .catch((error) => {
            console.error(error);
            toast.error("It seems server is down", {
              position: "top-right",
              autoClose: 3000,
              hideProgressBar: false,
              closeOnClick: true,
              pauseOnHover: true,
              draggable: true,
              progress: undefined,
            });
          });
        e.preventDefault();
      };
   

  return (
    <div>
      <div className="mt-2 d-flex aligns-items-center justify-content-center">
        <div className="form-card border-color" style={{ width: "37rem" }}>
          <div className="container">
            <div
              className="card-header bg-color custom-bg-text mt-2 d-flex justify-content-center align-items-center"
              style={{
                borderRadius: "0em",
                height: "38px",
              }}
            >
              <h4 className="card-title">User Login</h4>
            </div>
            <div className="card-body mt-1">
              <form>
                <div className="mb-1 text-color">
                  <label for="email" class="form-label">
                    <b>Email Id</b>
                  </label>
                  <input
                    type="email"
                    className="form-control"
                    id="email"
                    name="email"
                    onChange={handleUserInput}
                    value={loginRequest.email}
                  />
                </div>
                <div className="mb-1 text-color">
                  <label for="password" className="form-label">
                    <b>Password</b>
                  </label>
                  <input
                    type="password"
                    className="form-control"
                    id="password"
                    name="password"
                    onChange={handleUserInput}
                    value={loginRequest.password}
                    autoComplete="on"
                  />
                </div>
                <div className="d-flex aligns-items-center justify-content-center">
                  <button
                    type="button"
                    class="btn btn-danger"
                    // style={{backgroundColor:"red"}}
                    //className="btn bg-color custom-bg-text"
                    onClick={loginAction}
                    >
                    Login
                  </button>
                </div>
                <ToastContainer />
              </form>
            </div>
          </div>
        </div>
      </div>
      {/* <Footer/> */}
    </div>

  );
};

export default Login;