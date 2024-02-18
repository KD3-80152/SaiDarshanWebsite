import axios from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useEffect, useState} from "react";

const UserAllPooja = () => {
  

  const jwt = sessionStorage.getItem("jwtToken")  

  const getUserAllPooja=()=>{
    axios.get("https://localhost:8443/user/pooja/",{
      headers:{
        "Authorization":"Bearer "+jwt
      }
    }).then(
        (response) => {
          console.log("Successfull");
          toast.success("All Pooja");
          setPooja(response.data);
        }).catch(
        (error) => {
          //For Failure
          console.log("Error!!!!!");
          toast.error("Something Went Wrong In Pooja");
        }
    );
    } 


    const deletePoojaById=(poojaId)=>{
        console.log(poojaId);
        axios.delete(` https://localhost:8443/user/pooja/${poojaId}`,{
          headers:{
            "Authorization":"Bearer "+jwt 
          }
        }).then((response)=>{
          console.log(response.data);
          toast.success(response.data);
          setPooja(pooja.filter((p) => p.id !== poojaId));
        },error=>{
          console.log("Error");
          toast.error("Something went wrong");
        });
      }

  useEffect(()=>{   
    getUserAllPooja();
},[]) //For Success
         


  const [pooja, setPooja] = useState([]);

  return (
    <div>
      <div style={{ color: "red", fontStyle: "italic" }}>
        <h4>My All Pooja</h4>
      </div>
      <hr />

      <div className="text-center" style={{ margin: "auto" }}>
        <table className="table table-striped table-hover">
          <thead>
            <tr>
              <th scope="col">Pooja</th>
              <th scope="col">Date</th>
              <th scope="col">No Of Person</th>
              <th scope="col">Amount</th>
              <th scope="col">Primary Devotee Name</th>
              <th scope="col">AadharNo</th>
              <th scope="col">Id</th>
               <th> Action</th>
            </tr>
          </thead>

          <tbody>
            {pooja.map((p) => (
              <tr key={p.id}>
                <td>{p.pooja}</td>
                <td>{p.date}</td>
                <td>{p.noOfPerson}</td>
                <td>{p.amount}</td>
                <td>{p.primaryDevoteeName}</td>
                <td>{p.adharNo}</td>
                <td>{p.id}</td>
                <td>
                <button

                    onClick={()=>deletePoojaById(p.id)}
                    type="button"
                    className={"btn btn-danger"}
                    style={{ backgroundColor: "" }}
                  >
                    DELETE
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default UserAllPooja;
