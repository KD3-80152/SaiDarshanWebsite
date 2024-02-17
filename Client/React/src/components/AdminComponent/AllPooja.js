import axios from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useState} from "react";

const AllPooja = () => {
  axios.get("https://localhost:8443/admin/allPooja").then(
    (response) => {
      //For Success
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
                <td>{p.noofperson}</td>
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
