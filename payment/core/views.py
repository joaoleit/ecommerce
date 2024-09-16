from django.core.exceptions import FieldError

from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework.permissions import AllowAny
from rest_framework import status
import time
import random
from enum import Enum
import json


class PaymentView(APIView):
    permission_classes = [AllowAny]

    def post(self, request):
        time.sleep(random.uniform(1, 5))
        m = random.choice(['SUCCESS', 'FAILURE'])
        return Response(m, status=status.HTTP_200_OK)