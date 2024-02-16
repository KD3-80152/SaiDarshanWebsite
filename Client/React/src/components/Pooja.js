import Common from './Common';
import { useEffect } from 'react';

const Pooja =()=>{

  useEffect(()=>{
    document.title="Pooja";
  },[]);


    return(
        <div style={{margin:'auto'}}>
           <div>
            <Common/>
          </div>

          <div id="pooja">
          <h4 style={{ color: "red", marginLeft:10, marginTop: 10 }}>Pooja</h4>
          <hr />

          <div className='row' style={{marginLeft:10, fontSize:18}}>
            <label class="textf ng-binding" for="inputLarge">
              Pooja
              <sup className="text-danger"> *</sup>
            </label>


          </div>

          </div>

        </div>
    )
}

export default Pooja;