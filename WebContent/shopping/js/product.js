//検索リセットが押された場合
		function PushReset(){
		 document.inform.keyword.value="";
		 document.inform.price.value="300";
		 document.inform.submit();
		 }

		// 価格変更スライダー
		$(function() {
			var val = 300;
		  // スライダーを適用
		  $('#slider').slider({
		    min: 0,
		    max: 300,
		    step: 10,
		    value: val,
		    // スライダーの変化時にテキストボックスの値表示を更新
		    change: function(e, ui) {
		      $('#num').val(ui.value);
		    },
		    // 4スライダーの初期化時に、その値をテキストボックスにも反映
		    create: function(e, ui) {
		      $('#num').val($(this).slider('option', 'value'));
		    }
		  });
		});

