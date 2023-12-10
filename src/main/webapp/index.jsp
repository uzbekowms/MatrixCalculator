<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Main page</title>
  </head>
  <body>
    <form action="/matrix" method="post">
      <fieldset>
        <legend>A</legend>
        <input type="number" name="numA" required/>
        <input type="number" name="numA" required/>
        <input type="number" name="numA" required/>
        <br />
        <input type="number" name="numA" required/>
        <input type="number" name="numA" required/>
        <input type="number" name="numA" required/>
        <br />
        <input type="number" name="numA" required/>
        <input type="number" name="numA" required/>
        <input type="number" name="numA" required/>
      </fieldset>
      <select name="operation" id="" required>
        <option value="add">A + B</option>
        <option value="sub">A - B</option>
        <option value="mul">A * B</option>
      </select>
      <fieldset>
        <legend>B</legend>
        <input type="number" name="numB" required/>
        <input type="number" name="numB" required/>
        <input type="number" name="numB" required/>
        <br />
        <input type="number" name="numB" required/>
        <input type="number" name="numB" required/>
        <input type="number" name="numB" required/>
        <br />
        <input type="number" name="numB" required/>
        <input type="number" name="numB" required/>
        <input type="number" name="numB" required/>
      </fieldset>
      <button>Send</button>
    </form>
  </body>
</html>
