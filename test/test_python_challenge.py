from python.python_challenge import digits_count
import pytest


@pytest.mark.parametrize("test_num, expected", (
    (100, 3), (55555, 5), (1.1e6, 7), (1289396387328, 13), (121317, 6),
    (0, 1), (9.9e15, 16)
))
def test_digits_count(test_num, expected):
    assert digits_count(test_num) == expected
