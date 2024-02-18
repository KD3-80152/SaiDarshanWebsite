
import Common from "./Common";


const Pooja = () => {
  return (
    <div style={{ margin: "auto" }}>
      <div>
        <Common />
      </div>

      <div id="pooja" className>
        <h4 style={{ color: "red", marginLeft: 10, marginTop: 10 }}>Pooja</h4>
        <hr />

        <div  style={{ marginLeft: 10, fontSize: 18 }}>
          <label class="textf ng-binding" for="inputLarge">
            Pooja
            <sup className="text-danger"> *</sup>
          </label>

          <div className="col-md-2 mb-2" style={{marginLeft:100,marginTop:-50}}>
            <label htmlFor="pooja" className="form-label">
              {/* <b>Gender</b> */}
            </label>
            <select
              className="form-select"
              id="gender"
              name="gender"
              // onChange={handleUserInput}
              // value={user.gender}
            >
              <option value="">Select Gender</option>
              <option value="MALE">Male</option>
              <option value="FEMALE">Female</option>
              <option value="OTHER">Other</option>
            </select>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Pooja;
