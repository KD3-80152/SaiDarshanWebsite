import axios from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useEffect, useState} from "react";

const AllPooja = () => {
 
  const getAllPooja=()=>{
    axios.get("https://localhost:8443/admin/pooja/all",{
      headers:{
        "Authorization":"Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwcmFzaGFudEBnbWFpbC5jb20iLCJpYXQiOjE3MDgxNzIwMDIsImV4cCI6MTcwODI1ODQwMiwiYXV0aG9yaXRpZXMiOiJST0xFX0FETUlOIiwidXNlcklkIjoxfQ.SzgR0Ef2Ijdylo1YolMLFvhWzAw059TnJl-qqFWUXc91oWnTOZ2SXBnZtiS7UYY8gsYJFxhXuhFpw5-6ZK2Mbg"
      }
    }).then(
        (response) => {
          console.log("Successfull");
          toast.success("All Pooja");
          setPooja(response.data);
        },
        (error) => {
          //For Failure
          console.log("Error!!!!!");
          toast.error("Something Went Wrong In Pooja");
        }
      );
  }
  useEffect(()=>{
    getAllPooja();
  },[]) //For Success
         


  const [pooja, setPooja] = useState([]);

  return (
    <div className="">
      <div style={{ color: "red", fontStyle: "italic" }}>
        <h4>AllPooja</h4>
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
                    className={"btn"}
                    style={{ backgroundColor: "orange" }}
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

export default AllPooja;
