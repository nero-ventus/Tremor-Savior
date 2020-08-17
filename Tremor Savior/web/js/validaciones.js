function email() {
                var letras = "@._-1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                var x = event.keyCode;
                var letra = String.fromCharCode(x);
                var n = letras.indexOf(letra);
                if (n === -1) {
                    event.returnValue = false;


                }
            }
            function alfanumerico() {
                var letras = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";
                var x = event.keyCode;
                var letra = String.fromCharCode(x);
                var n = letras.indexOf(letra);
                if (n === -1) {
                    event.returnValue = false;


                }
            }
            function numerico() {
                var letras = "1234567890";
                var x = event.keyCode;
                var letra = String.fromCharCode(x);
                var n = letras.indexOf(letra);
                if (n === -1) {
                    event.returnValue = false;


                }
            }
            function letras() {
                var letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";
                var x = event.keyCode;
                var letra = String.fromCharCode(x);
                var n = letras.indexOf(letra);
                if (n === -1) {
                    event.returnValue = false;


                }
            }
