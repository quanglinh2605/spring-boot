$(document).ready(function (){
	
	$('#comboboxCinemas').on('change',function(){
		var cinemaId = $('#comboboxCinemas option:selected').val();
		$.ajax({
			type: 'GET',
			url: '/admin/room/listByCinemaId/' + cinemaId,		
			success: function(response){
				var result = JSON.parse(response);
				var s = '<option selected>Select one</option>';
				for (var i = 0; i < result.length; i++) {
					s += '<option value = "'+ result[i].roomId + '">' + result[i].roomName + '</option>'
				}
				$('#comboboxRooms').html(s);
			},
			error: function (e) {
	            console.log("ERROR : ", e);
	        }
		});
	});
	
	$('#comboboxCinemas1').on('change',function(){
		var cinemaId = $('#comboboxCinemas1 option:selected').val();
		$.ajax({
			type: 'GET',
			url: '/admin/room/listByCinemaId/' + cinemaId,		
			success: function(response){
				var result = JSON.parse(response);
				var s = '<option selected>Select one</option>';
				for (var i = 0; i < result.length; i++) {
					s += '<option value = "'+ result[i].roomId + '">' + result[i].roomName + '</option>'
				}
				$('#comboboxRooms1').html(s);
			},
			error: function (e) {
	            console.log("ERROR : ", e);
	        }
		});
	});
	
	$('#comboboxRooms').on('change',function(){
		var room_id = $('#comboboxRooms option:selected').val();
		$.ajax({
			type: 'GET',
			url: '/admin/seat/findByRoom/' + room_id,		
			success: function(response){
				var result = JSON.parse(response);
				var s = '';
				for (var i = 0; i < result.length; i++) {
					s += '<tr>';
					s += '<td>' + (i+1) + '</td>';
					s += '<td>' + result[i].room.roomName + '</td>';
					s += '<td>' + result[i].row + '</td>';
					s += '<td>' + result[i].number + '</td>';
					s += '<td>' + result[i].srat_type + '</td>';
					s += '<td>' + (result[i].checked == true ? 'Booked':'Empty') + '</td>';
					s += '<td><a href="/admin/seat/delete/' + result[i].seat_id + '" onclick="return confirm(\'Are you sure\')">Delete</a> |' + 
					 '<a href="/admin/seat/edit/' + result[i].seat_id + '">Edit</a></td>';
					s += '</tr>';
				}
				$('#seatTable tbody').html(s);
			},
			error: function (e) {
	            console.log("ERROR : ", e);
	        }
		});
	});
	
	$('#comboboxMonth').on('change', function(){
		var month = $('#comboboxMonth option:selected').val();		
		$.ajax({
			type : 'GET',
			url : '/admin/report/findByMonth/' + month,
			success: function(response){
				var result = JSON.parse(response);
				var s = '';
				for (var i = 0; i < result.length; i++) {
					s += '<tr>';
					s += '<td>' + (i+1) + '</td>';
					s += '<td>' + result[i].cinema + '</td>';
					s += '<td>' + result[i].bookingNumber + '</td>';					
					s += '</tr>';
				}
				$('#bookingNumber tbody').html(s);
			},
			error: function (e) {
	            console.log("ERROR : ", e);
	        }
		});
	});
	$('#comboboxMonth').on('change', function(){
		var month = $('#comboboxMonth option:selected').val();
		$.ajax({
			type : 'GET',
			url : '/admin/report/totalByMonth/' + month,
			success: function(response){
				var result = JSON.parse(response);
				var s = '';
				s += 'Month\'s Revenue: ' + result + '$';
				$('#total').html(s);
			},
			error: function (e) {
	            console.log("ERROR : ", e);
	            $('#total').html('Month\'s Revenue: 0' + '$')
	        }
		});
	});
	
	$('doccument').querySelector('.clocklet-scroll-into-view')
    .addEventListener('clocklet.opened', function (event) {
      requestAnimationFrame(function () {
        var inputRect = event.target.getBoundingClientRect();
        var clockletRect = clocklet.root.getBoundingClientRect();
        scroll({
          top:  document.documentElement.scrollTop
              + document.body.scrollTop
              + (event.detail.options.placement === 'top' ? clockletRect.top : inputRect.top)
              - 10,
          left: document.documentElement.scrollLeft
              + document.body.scrollLeft
              + clockletRect.left
              - 10,
          behavior: 'smooth',
        });
      });
    });
	
});
$(function (){
	$('#AlertBox').removeClass('hide');
	$('#AlertBox').delay(1000).slideUp(500);
	check = $('#add').val();
	if(check == "open"){
		$('#myModal').modal('show');
	}	
});