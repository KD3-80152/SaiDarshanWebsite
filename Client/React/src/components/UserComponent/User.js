import Content from "./Content";
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import NavBar from "../NavBar";

const User = () => {
  const navigate = useNavigate();

  const handleLogout = () => {

    sessionStorage.removeItem("jwtToken");
    toast.success("Come Back Agin!!!", {
      position: "top-center",
      autoClose: 3000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
      progress: undefined,
    });

    // Navigate to another page after a delay
    setTimeout(() => {
      navigate("/home"); // Navigate to the "/next-page" route
    }, 3500); // Wait for 2 seconds before navigating
  };

  return (
    <div id="user">
      <div>
        <div>
          <div
            id="div1"
            style={{ backgroundColor: "orange" }}
            className="text-center"
          >
            <img
              src="https://online.sai.org.in/content/images/shirdi_logo.png"
              alt=""
            />
          </div>
        </div>

        <div id="div2" className="text-center">
          <h2 style={{ color: "maroon" }}>
            SHRI SAIBABA SANSTHAN TRUST,SHIRDI
          </h2>

          <button
            className={"btn"}
            style={{ backgroundColor: "orange", marginLeft: 1400 }}
            onClick={handleLogout}
          >
            Log Out
          </button>
        </div>

        <div>
        <NavBar/>
        </div>

        <div>
          <div className="row">
            <Content />
          </div>
        </div>
        <ToastContainer style={{ width: 800, height: 1000 }} />
      </div>
    </div>
  );
};

export default User;
