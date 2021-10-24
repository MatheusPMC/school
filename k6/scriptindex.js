import http from 'k6/http';
import { check, sleep } from 'k6';
import { SharedArray } from 'k6/data';
import papaparse from 'https://jslib.k6.io/papaparse/5.1.1/index.js';

const csvData = new SharedArray('users', function () {
   return papaparse.parse(open('./data.csv'), { header: true }).data;
});

const data = new SharedArray('users', function () {
  return JSON.parse(open(csvData), { header: true }).data;
});

export default function () {
  for (const userPwdPair of data) {
    var randomUser = data[Math.floor(Math.random() * data.length)];
  }
  const url = 'http://localhost:8080'
  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  const res = http.post(url, JSON.stringify(randomUser), params);
  check(res, {
    'created succeeded': (r) => r.status === 201,
  });

  console.log(res.body)


  sleep(1);
}