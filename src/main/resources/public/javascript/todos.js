// Why do we use the `var getAllUsers = function()` syntax
// for the first definition, and the named function syntax
// for the second definition?




/**
 * Function to get all the users!
 */
function getAllTodos() {
  console.log("Getting all the todos.");

  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos", function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}
function getID(){
  console.log("Getting ID.");

  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos/" + document.getElementById("id").value, function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getAllTodosByFilter() {
  console.log("Getting all the todos.");

  var todoURL= "/api/todos";
  var isFiltered = false;
  if(document.getElementById("status").value != ""){
    if(isFiltered){
      todoURL = todoURL + "&status=" + document.getElementById("status").value;
    }else{
      todoURL = todoURL + "?status=" + document.getElementById("status").value;
      isFiltered = true;
    }
  }


  if(document.getElementById("contains").value != ""){
    if(isFiltered){
      todoURL = todoURL + "&contains=" + document.getElementById("contains").value;
    }else{
      todoURL = todoURL + "?contains=" + document.getElementById("contains").value;
      isFiltered = true;
    }



  }

  if(document.getElementById("owner").value != ""){
    if(isFiltered){
      todoURL = todoURL + "&owner=" + document.getElementById("owner").value;
    }else{
      todoURL = todoURL + "?owner=" + document.getElementById("owner").value;
      isFiltered = true;
    }

    }

  if(document.getElementById("category").value != ""){
    if(isFiltered){
      todoURL = todoURL + "&category=" + document.getElementById("category").value;
    }else{
      todoURL = todoURL + "?category=" + document.getElementById("category").value;
      isFiltered = true;
    }

  }
  if(document.getElementById("limit").value != ""){
    if(isFiltered){
      todoURL = todoURL + "&limit=" + document.getElementById("limit").value;
    }else{
      todoURL = todoURL + "?limit=" + document.getElementById("limit").value;
      isFiltered = true;
    }
  }



  var HttpThingy = new HttpClient();
  HttpThingy.get(todoURL, function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });


}




/**
 * Wrapper to make generating http requests easier. Should maybe be moved
 * somewhere else in the future!.
 *
 * Based on: http://stackoverflow.com/a/22076667
 * Now with more comments!
 */
function HttpClient() {
  // We'll take a URL string, and a callback function.
  this.get = function(aUrl, aCallback){
    var anHttpRequest = new XMLHttpRequest();

    // Set a callback to be called when the ready state of our request changes.
    anHttpRequest.onreadystatechange = function(){

      /**
       * Only call our 'aCallback' function if the ready state is 'DONE' and
       * the request status is 200 ('OK')
       *
       * See https://httpstatuses.com/ for HTTP status codes
       * See https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
       *  for XMLHttpRequest ready state documentation.
       *
       */
      if (anHttpRequest.readyState === 4 && anHttpRequest.status === 200)
        aCallback(anHttpRequest.responseText);
    };

    anHttpRequest.open("GET", aUrl, true);
    anHttpRequest.send(null);
  }
}
