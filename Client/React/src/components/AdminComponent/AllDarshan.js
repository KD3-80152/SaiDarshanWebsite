import React from "react";
import axios from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useState,useEffect } from "react";

const AllDarshan = () => {

  const getAllDarshan=()=>{
    axios.get("https://localhost:8443/admin/darshan/all",{
      headers:{
        "Authorization":"Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwcmFzaGFudEBnbWFpbC5jb20iLCJpYXQiOjE3MDgxNzIwMDIsImV4cCI6MTcwODI1ODQwMiwiYXV0aG9yaXRpZXMiOiJST0xFX0FETUlOIiwidXNlcklkIjoxfQ.SzgR0Ef2Ijdylo1YolMLFvhWzAw059TnJl-qqFWUXc91oWnTOZ2SXBnZtiS7UYY8gsYJFxhXuhFpw5-6ZK2Mbg"
      }
    }).then(
        (response) => {
          console.log("Successfull");
          toast.success("All Darshan");
          setDarshan(response.data);
        },
        (error) => {
          //For Failure
          console.log("Error!!!!!");
          toast.error("Something Went Wrong In Darshan");
        }
      );
  }

  useEffect(()=>{
    getAllDarshan();
  },[]) //For Success

  const [darshan, setDarshan] = useState([]);


  return (
    <div>
      <div style={{ color: "red", fontStyle: "italic" }}>
        <h4>All Darshan</h4>
      </div>
      <hr />

      <div className="text-center" style={{ margin: "auto" }}>
        <table className="table table-striped table-hover">
          <thead>
            <tr>
              <th scope="col"></th> 
              <th scope="col"></th>
              <th scope="col"></th>
              <th scope="col"></th>
              <th scope="col"></th>
              <th scope="col"></th>
              <th scope="col"></th> 
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {darshan.map((d) => (
              <tr key={d.id}>
                <td>{d.numberOfDays}</td>
                <td>{d.checkInDate}</td>
                <td>{d.checkInTime}</td>
                <td>{d.numberOfRooms}</td>
                <td>{d.primaryDevoteeName}</td>
                <td>{d.adharNo}</td>
                <td>
                <button
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

export default AllDarshan;
