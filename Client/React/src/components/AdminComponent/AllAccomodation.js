import React from "react";
import axios from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useState } from "react";

const AllAccomodation = () => {
  axios.get("https://localhost:8443/admin/allAccomodation").then(
    (response) => {
      //For Success
      console.log("Successfull");
      toast.success("All Accomodation");
      setAccomodation(response.data);
    },
    (error) => {
      //For Failure
      console.log("Error!!!!!");
      toast.error("Something Went Wrong In Accomodation");
    }
  );

  const [accomodation, setAccomodation] = useState([]);

  return (
    <div>
      <div style={{ color: "red", fontStyle: "italic" }}>
        <h4>All Accomodation</h4>
      </div>
      <hr />
      <div className="text-center" style={{ margin: "auto" }}>
        <table className="table table-striped table-hover">
          <thead>
            <tr>
              <th scope="col">No Of Days</th>
              <th scope="col">Check In Date</th>
              <th scope="col">Check In Time</th>
              <th scope="col">No of Rooms</th>
              <th scope="col">Primary Devotee Name</th>
              <th scope="col">AadharNo</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {accomodation.map((ac) => (
              <tr key={ac.id}>
                <td>{ac.numberOfDays}</td>
                <td>{ac.checkInDate}</td>
                <td>{ac.checkInTime}</td>
                <td>{ac.numberOfRooms}</td>
                <td>{ac.primaryDevoteeName}</td>
                <td>{ac.adharNo}</td>
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

export default AllAccomodation;
