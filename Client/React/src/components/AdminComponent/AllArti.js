import React from "react";
import axios from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useState,useEffect } from "react";

const AllArti = () => {

  const getAllArti=()=>{
    axios.get("https://localhost:8443/admin/aarti/all",{
      headers:{
        "Authorization":"Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwcmFzaGFudEBnbWFpbC5jb20iLCJpYXQiOjE3MDgxNzIwMDIsImV4cCI6MTcwODI1ODQwMiwiYXV0aG9yaXRpZXMiOiJST0xFX0FETUlOIiwidXNlcklkIjoxfQ.SzgR0Ef2Ijdylo1YolMLFvhWzAw059TnJl-qqFWUXc91oWnTOZ2SXBnZtiS7UYY8gsYJFxhXuhFpw5-6ZK2Mbg"
      }
    }).then(
        (response) => {
          console.log("Successfull");
          toast.success("All Aarti");
          setAarti(response.data);
        },
        (error) => {
          //For Failure
          console.log("Error!!!!!");
          toast.error("Something Went Wrong In Pooja");
        }
      );
  }
  useEffect(()=>{
    getAllArti();
  },[]) //For Success

  const [aarti, setAarti] = useState([]);

  return (
    <div>
      <div style={{ color: "red", fontStyle: "italic" }}>
        <h4>All Arti</h4>
      </div>
      <hr />
      <div className="text-center" style={{ margin: "auto" }}>
        <table className="table table-striped table-hover">
          <thead>
            <tr>
              <th scope="col">Aarti Booking Date</th>
              <th scope="col">Aarti Booking Type</th>
              <th scope="col">No Of Person</th>
              <th scope="col">Amount</th>
              <th scope="col">Primary Devotee Name</th>
              <th scope="col">AadharNo</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {aarti.map((a) => (
              <tr key={a.id}>
                <td>{a.aartiBookingDate}</td>
                <td>{a.aartiBookingType}</td>
                <td>{a.noOfPerson}</td>
                <td>{a.amount}</td>
                <td>{a.primaryDevoteeName}</td>
                <td>{a.adharNo}</td>
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

export default AllArti;
