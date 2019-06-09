;Write a function (NumberOfPrimes <list>) which counts
;the number of primes in a (possibly nested) list.
(number-of-primes '(((1)(2))(5)(3)((8)3)))

(defun number-of-primes (list-input &optional (sum 0))
  (let ((flag nil))
    (loop for element in list-input
      do(if (typep element 'list)
            (setf sum (number-of-primes element sum))
            (cond ((= element 1))
                  ((= element 2) (setf sum (+ sum 1)))
                  (t (loop for i from 2 to (- element 1)
                      do(if (= (rem element i) 0)
                            (setf flag t)
                            ())
                      finally(if (eq flag t)
                                 (setf flag nil)
                                 (setf sum (+ sum 1))))))))
    sum))
;Define a function (even <list>) which returns the subset (a list) of even
;numbers contained in a given numeric, possibly nested list.
(even '(1 2 (3 4) -4))

(defun even (list-input &optional (result '()))
  (let ((result result))
    (loop for element in list-input
      do(if (typep element 'list)
            (setf result (even element result))
            (if (= (rem element 2) 0)
                (setf result (append result (list element)))
                ())))
    result))
;Define a function (SumIfNot <list1> <list2>) that returns the sum of all
;elements in list2 that do not appear in list1. Both lists may be nested lists.
(sum-if-not '(1 8 (2)) '(1 (3 (8)) 8 9))

(defun flatten (input)
  (cond ((null input) nil)
        ((atom input) (list input))
        (t (loop for element in input append (flatten element)))))

(defun sum-if-not (list1 list2)
  (let ((sum 0))
    (dolist (element (set-difference (flatten list2) (flatten list1)))
      (setf sum (+ sum element)))
    sum))
