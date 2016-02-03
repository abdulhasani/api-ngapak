    //get
    $(function(){
        get_cities();
    });

    var get_cities = function() {
        $.ajax({
            url: '/api/person',
            processData:false,
            type: 'GET',
            dataType: 'json',
//            beforeSend:function(jqXHR, settings){
//                jqXHR.setRequestHeader('Content-Type', 'application/json');     //ini tipe data json
//            },
            success: function(data, textStatus, jqXHR){
                process_person(data.data.items);      //data.data karena ada objek di dalam objek
                console.log(data.data.items);      //kebenaran ditegakkan!
            }
        });
    };



    //ambil data person
    var process_person = function(person){  //person ngambil dari data.data
        $.each(person,function(i,orang){ //looping untuk array
            $("#dataTables-person tbody").append(
            '<tr>'+
            "<td>"+ orang.nama +"</td>"+
            "<td>" +orang.alamat +"</td>"+
            "<td>" +orang.umur +"</td>"+
            "<td><a href='#' class='btn btn-danger btn-xs' title='delete' ><i class='fa fa-times fa-left'></i></a>"+
            "<a href='#' class='btn btn-info btn-xs' title='edit location' ><i class='fa fa-edit fa-left'></i></a>"+
            "</tr>"
            );
        });
//        $('#nama').html(orang.nama); //ambil value lalu lempar ke html
//        $('#umur').html(orang.umur);
//        $('#lokasi').html(orang.alamat);
    };

    //post
    function submitForm(){
//        var formData = {
//            nama: "Albert",
//            alamat: "Jakarta",
//            umur: 14
//        };
//        // construct an HTTP request
//        var xhr = new XMLHttpRequest();
//        xhr.open('POST', 'api/person/create' );
//        console.log(JSON.stringify(formData));
//
//        // send the collected data as JSON
//        xhr.send(JSON.stringify(formData));
//        event.preventDefault();
//
//
//        xhr.onloadend = function () {
//          // done
//          }

        var formData = {
            nama: "Albert",
            alamat: "Jakarta",
            umur: 14
        };
        $.ajax({
            type: 'POST',
            url: 'api/person/create',
            data: JSON.stringify(formData),
            beforeSend:function(jqXHR, settings){
                jqXHR.setRequestHeader('Content-Type', 'application/json');     //ini tipe data json
            },
            //dataType: "json",
            success: function(data){
                alert(data);
                var acak = JSON.stringify(formData);      //data.data karena ada objek di dalam objek
                console.log(data);      //kebenaran ditegakkan!

            },
            failure: function(errMsg) {
                    alert(errMsg);
            }
        });
        event.preventDefault();
    };